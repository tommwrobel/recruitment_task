package impl;

import i.ICompositeNode;
import i.INode;

import java.util.ArrayList;
import java.util.List;

public class MyCompositeNode implements ICompositeNode {
    private List<INode> nodes;
    private String code;
    private String renderer;

    public MyCompositeNode(String code, String renderer) {
        this.code = code;
        this.renderer = renderer;
        this.nodes = new ArrayList<>();
    }

    public boolean addNode(INode node) {
        return nodes.add(node);
    }

    @Override
    public List<INode> getNodes() {
        return nodes;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getRenderer() {
        return renderer;
    }

    @Override
    public String toString() {
        return "impl.MyCompositeNode{" +
                "code='" + code + '\'' +
                ", renderer='" + renderer + '\'' +
                '}';
    }
}
