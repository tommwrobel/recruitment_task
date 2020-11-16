package impl;

import i.ICompositeNode;
import i.IMyStructure;
import i.INode;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MyStructure implements IMyStructure {
    private List<INode> nodes;

    public MyStructure() {
        this.nodes = new ArrayList<>();
    }

    public boolean addNode(INode node) {
        return nodes.add(node);
    }

    @Override
    public INode findByCode(String code) {
        return findBy(isMatchingNodeCode(code));
    }

    @Override
    public INode findByRenderer(String renderer) {
        return findBy(isMatchingNodeRenderer(renderer));
    }

    @Override
    public int count() {
        int counter = 0;
        for (INode node : nodes) {
            counter++;
            if (isCompositeNode.test(node)) {
                MyStructure myStructure = new MyStructure();
                for (INode node1 : ((ICompositeNode) node).getNodes()) {
                    myStructure.addNode(node1);
                }
                counter += myStructure.count();
            }
        }
        return counter;
    }

    private INode findBy(Predicate<INode> predicate) {
        INode result = null;

        for (INode node : nodes) {
            if (predicate.test(node)) {
                return node;
            } else if (isCompositeNode.test(node)) {
                MyStructure myStructure = new MyStructure();
                for (INode node1 : ((ICompositeNode) node).getNodes()) {
                    myStructure.addNode(node1);
                }
                result = myStructure.findBy(predicate);
            }
        }
        return result;
    }

    Predicate<INode> isCompositeNode = node -> node instanceof ICompositeNode;

    Predicate<INode> isMatchingNodeCode(String code) {
        return node -> node.getCode().equals(code);
    }

    Predicate<INode> isMatchingNodeRenderer(String renderer) {
        return node -> node.getRenderer().equals(renderer);
    }
}