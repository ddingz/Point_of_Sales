package pos;

import java.time.LocalDateTime;

public class Item {
	private int id;
	private String name;
	private int quantity;
	private int price;
	private LocalDateTime date;

	public Item(String name, int quantity, int price) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public Item(String name, int quantity, int price, LocalDateTime date) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
}