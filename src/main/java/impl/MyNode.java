package impl;

import i.INode;

import java.util.Objects;

public class MyNode implements INode {
    private String code;
    private String renderer;

    public MyNode(String code, String renderer) {
        this.code = code;
        this.renderer = renderer;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyNode myNode = (MyNode) o;
        return code.equals(myNode.code) &&
                renderer.equals(myNode.renderer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, renderer);
    }

    @Override
    public String toString() {
        return "impl.MyNode{" +
                "code='" + code + '\'' +
                ", renderer='" + renderer + '\'' +
                '}';
    }
}
