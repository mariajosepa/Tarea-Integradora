package ui;
import model.*; 
import java.util.*;


public class Main { 

	    public static final double DESIGN_STAGE = 1300000;
		public static final double POST_CONSTRUCTION = 2600000;
		public static final double PAINT = 980000;

	public static int getNumberMaterials(){

		int numberMaterials;
		Scanner input = new Scanner(System.in);

		System.out.println("Ingrese el numero de materiales que necesita");
		numberMaterials = input.nextInt();
		input.nextLine();

		return numberMaterials; 
	}

	public static String getLocation(){


		Scanner input = new Scanner(System.in);

		boolean wrongInput = true;
		String location = "";

		while (wrongInput == true){

		System.out.println("Ingrese su ubicacion");

		System.out.println("Norte	    [n]");
		System.out.println("Centro      [c]");
		System.out.println("Sur         [s]");

		location = input.next();

		if (!location.equalsIgnoreCase("n") && !location.equalsIgnoreCase("c") && !location.equalsIgnoreCase("s")){

			System.out.println("Esa ubicacion no es valida");
			wrongInput = true;
		}

		else 
		{

			wrongInput = false;
		}

	}
		return location;
	}

	public static String getName(){

		Scanner input = new Scanner(System.in);

		System.out.println("Ingrese nombre del material: ");
		String name = input.next();

		return name;

		}

	public static int getCategory(){

		Scanner input = new Scanner(System.in);

		System.out.println("Ingrese categoria del material: ");

		System.out.println("Obra negra  [1]");
		System.out.println("Obra blanca [2]");
		System.out.println("Pintura     [3]");
		int category = input.nextInt();

		return category;

	}


	public static void main(String [] args){

		Scanner input = new Scanner (System.in);

		int numberMaterials = getNumberMaterials();

		String [] materials = new String [numberMaterials];
		String [] designStage = new String [numberMaterials];
		String [] postConstruction = new String[numberMaterials];
		String [] paint = new String[numberMaterials];

	  
	    double [] homeCenter = new double[numberMaterials];
	    double [] ferreteriaCentro = new double[numberMaterials];
	    double [] ferreteriaBarrio = new double [numberMaterials];

	    double [] bestPrice = new double[numberMaterials];
        String [] bestPlace = new String [numberMaterials];
	    
		int category = 0;

		double total = 0;
		
		Operation op = new Operation();

		String location = getLocation();

		

		for (int i = 0; i<numberMaterials; i++){

			materials[i] = getName();

			category = getCategory();

			System.out.println("Ingrese precio del material en Home Center");
			homeCenter[i]=input.nextDouble();

			System.out.println("Ingrese precio del material en Ferreteria del Centro");
			ferreteriaCentro[i]=input.nextDouble();

			System.out.println("Ingrese precio del material en Ferreteria del Barrio");
			ferreteriaBarrio[i]=input.nextDouble();


			if (category == 1)
				designStage[i]=materials[i];

			if(category == 2)
				postConstruction[i]=materials[i];

			if(category==3)
				paint[i]=materials[i];

		}
		

			for (int x = 0; x < numberMaterials;x++){

				bestPrice[x] = op.bestPrice(homeCenter[x],ferreteriaCentro[x],ferreteriaBarrio[x]);

				bestPlace[x] = op.bestPlace(bestPrice[x], homeCenter[x], ferreteriaBarrio[x], ferreteriaCentro[x]);

			}


			

			System.out.println("Materiales de OBRA NEGRA:  ");
			op.asignPlace(numberMaterials, designStage ,materials, bestPrice, bestPlace);


			System.out.println("Materiales de OBRA BLANCA:  ");
			op.asignPlace(numberMaterials, postConstruction, materials, bestPrice, bestPlace);


			System.out.println("Materiales de PINTURA:  ");
			op.asignPlace(numberMaterials, paint, materials, bestPrice, bestPlace);



       total = op.sumTotal(bestPrice, location);
       System.out.println("El total a pagar es de  " + (total + DESIGN_STAGE + POST_CONSTRUCTION + PAINT));



	}
}	
