package Strategy_Pattern_mid;

interface Recipe {
	public void cook();
}

class Ramen {
	Recipe recipe = new GeneralRamenRecipe();

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public void cook() {
		recipe.cook();
	}
}

class GeneralRamenRecipe implements Recipe {
	public void cook() {
		System.out.println("일반 조리법으로 끓이기");
	}
}

class RamenWithoutBrothRecipe implements Recipe {
	public void cook() {
		System.out.println("물을 적게 넣고 라면을 익힌 뒤에 라면 스프에 볶듯이 끓임");
	}
}

class CheeseRamenRecipe implements Recipe {
	public void cook() {
		System.out.println("라면을 끓인 후에 치즈 넣기");
	}
}

class VinegarRamenRecipe implements Recipe {
	public void cook() {
		System.out.println("라면을 끓인 후에 식초 약간 넣기");
	}
}

class MilkRamenRecipe implements Recipe {
	public void cook() {
		System.out.println("우유를 넣고 끓이기");
	}
}

public class Main {
	public static void main(String[] args) {
		Ramen cook = new Ramen();
		cook.cook();
		cook.setRecipe(new CheeseRamenRecipe());
		cook.cook();
	}
}
