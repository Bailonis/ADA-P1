package prob;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Problem {

	private List<Offer> offers; // lista de todas as ofertas do problema atual
	private List<Integer> profits; // tabela do lucro maximo

	public Problem(int numOffers) {
		offers = new ArrayList<Offer>(numOffers);
		profits = new ArrayList<Integer>(numOffers);
	}
	public void newOffer(int start, int duration, int price) {

		Offer offer = new Offer(start, duration, price);
		offers.add(offer);
		profits.add(-1);

	}
	public int solve() {
		Collections.sort(offers);
		// preencher a tabela de lucros
		for (int i = 0; i < offers.size(); i++)
			profits.set(i, profit(i));
		// retornar o ultimo valor da tabela
		return profits.get(profits.size() - 1);
	}
	public int profit(int curr) {
		if (curr == -1)
			return 0;
		// caso o lucro da oferta atual ja se encontre na tabela de lucros
		if (profits.get(curr) != -1)
			return profits.get(curr);
		Offer temp = offers.get(curr);
		// procura o lucro da primeira oferta compativel
		for (int i = curr; i >= 0; i--) {
			if (temp.isCompatible(offers.get(i)))
				return Math.max(temp.getPrice() + profit(i), profit(curr - 1));
		}
		// caso nenhuma oferta seja compativel
		return Math.max(temp.getPrice(), profit(curr - 1));
	}
}
