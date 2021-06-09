package br.com.ambers.fiap.model;

public enum InventoryStatus {
	INSTOCK("In Stock"), OUTOFSTOCK("Out Of Stock"), LOWSTOCK("Low Stock");
	
	private String text;
	
	InventoryStatus(String string) {
		this.text = string;
	}

	public String getText() {
		return text;
	}


}
