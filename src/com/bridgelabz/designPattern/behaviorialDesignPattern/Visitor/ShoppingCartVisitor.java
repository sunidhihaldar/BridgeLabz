package com.bridgelabz.designPattern.behaviorialDesignPattern.Visitor;

public interface ShoppingCartVisitor {

	int visit(Book book);
	int visit(Fruit fruit);
}
