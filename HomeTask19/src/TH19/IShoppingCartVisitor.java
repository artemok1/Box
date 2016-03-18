package TH19;

public interface IShoppingCartVisitor {
	int visit(Book book);
	int visit(Fruit fruit);
}
