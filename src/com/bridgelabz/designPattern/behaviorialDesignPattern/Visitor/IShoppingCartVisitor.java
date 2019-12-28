package com.bridgelabz.designPattern.behaviorialDesignPattern.Visitor;

public interface IShoppingCartVisitor {

	int visit(Book book);
	int visit(Fruit fruit);
}
