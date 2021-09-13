package prob;
public class Offer implements Comparable<Offer> {
	private int start, duration, price;
	public Offer(int s, int d, int p) {
		start = s;
		duration = d;
		price = p;
	}
	public int getStartTime() {
		return start;
	}
	public int getDuration() {
		return duration;
	}
	public int getPrice() {
		return price;
	}
	// recebe uma oferta e diz se sao compativeis, ou seja se e possivel aceitar as
	// duas
	public boolean isCompatible(Offer off) {
		if (off == null)
			return true;
		return off.getStartTime() + off.getDuration() <= start || off.getStartTime() >= start + duration;
	}
	// as ofertas podem ser comparadas pelo momento final (inicio + duarcao) da
	// oferta
	@Override
	public int compareTo(Offer off) {
		int compareDuration = off.getDuration() + off.getStartTime();
		/* For Ascending order */
		return this.duration + this.start - compareDuration;
	}
}
