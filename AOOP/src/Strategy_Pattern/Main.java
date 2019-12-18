package Strategy_Pattern;

interface Recipe {

	public void cook();
}

class Ramen {

	Recipe r = new EggRamen();

	public void setRecipe(Recipe r) {
		this.r = r;
	}

	public void cook() {
		r.cook();
	}

}

class EggRamen implements Recipe {

	@Override
	public void cook() {
		System.out.println("계란라면");
	}

}

class MomRamen implements Recipe {

	@Override
	public void cook() {
		System.out.println("엄마표라면");
	}

}

public class Main {

	public static void main(String[] args) {

		Ramen r = new Ramen();
		r.setRecipe(new EggRamen());

		r.cook();

		r.setRecipe(new MomRamen());
		r.cook();
	}
}
