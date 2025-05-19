package structure.implementation;

import exception.EmptyStructureException;
import structure.nodes.Node;

public class DynamicQueueADT implements structure.definition.QueueADT {

    private Node first;

    @Override
    public int getElement() {
        if (this.isEmpty()) {
            throw new EmptyStructureException("No se puede obtener el primero de una cola vacia");
        }
        return this.first.getValue();
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public void add(int a) {
        if (this.first == null) {
            this.first = new Node(a, null);
            return;
        }

        Node candidate = this.first;
        while (candidate.getNext() != null) {
            candidate = candidate.getNext();
        }

        candidate.setNext(new Node(a, null));
    }

    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new EmptyStructureException("No se puede desacolar de una cola vacia");
        }
        this.first = this.first.getNext();
    }
}