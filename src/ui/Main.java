package ui;
import model.*; 
import java.util.*;


public class Main { 

	    public static final double DESIGN_STAGE = 1300000;
		public static final double POST_CONSTRUCTION = 2600000;
		public static final double PAINT = 980000;

		/**

		Returns an integer that represents the amount of materials needed 

		<b>pre: </b> <br>
		<b>post:  numberMaterials saves the amount of x material requested by the user </b> <br>

		
		*/

	public static int getNumberMaterials(){

		int numberMaterials;
		Scanner input = new Scanner(System.in);

		System.out.println("Ingrese el numero de materiales que necesita");
		numberMaterials = input.nextInt();
		input.nextLine();

		return numberMaterials; 
	}


		/**

		Returns a String with the location of the user 

		<b>pre: </b> <br>
		<b>post: location saves the location inputted by the user </b> <br>

	
		*/


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

		/**

		Returns a String with the name of the material inputted by the user 
		<b>pre: </b> <br>
		<b>post:  name saves the name of x material inputted by the user</b> <br>

	
		*/


	public static String getName(){

		Scanner input = new Scanner(System.in);

		System.out.println("Ingrese nombre del material: ");
		String name = input.next();

		return name;

		}


		/**

		Returns an int that represents the category of the material inputted by the user 

		<b>pre: </b> <br>
		<b>post:   category saves an integer between 1 and 3 that represents a construction stage  (Design stage, Post construction or paint)</b> <br>

	
		*/

	public static int getCategory(){

		Scanner input = new Scanner(System.in);

		boolean wrongInput = true;

		System.out.println("Ingrese categoria del material: ");

		System.out.println("Obra negra  [1]");
		System.out.println("Obra blanca [2]");
		System.out.println("Pintura     [3]");

		int category = input.nextInt();



		return category;

	}



		/**

		 Returns the price of x material, inputted by the user, at x store 

		<b>pre:  A String containing the name of x store has to be initialized </b> <br>
		<b>post: price saves the price of a material at x store </b> <br>

		@param place String containing the name of the store where x element is found

	
		*/


	public static double getPrice(String place){

		double price = 0;

		Scanner input = new Scanner (System.in);
		System.out.println("Ingrese precio del material en " + place);
		price = input.nextDouble();

		return price;


	}


		/**

		Returns an integer that represents the quantity of an item  

		<b>pre:  </b> <br>
		<b>post: quantity saves the amount of x material needed </b> <br>

	
		*/



		public static int getQuantity(){

		int quantity = 0;

		Scanner input = new Scanner (System.in);
		System.out.println("Ingrese cantidad del material que necesita ");
		quantity = input.nextInt();

		return quantity;


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

        String place1 = "Home Center";
        String place2 = "Ferreteria del Centro";
        String place3= "Ferreteria del Barrio";
	    
		int category = 0;
		int quantity = 0;

		double total = 0;
		
		Operation op = new Operation();

		String location = getLocation();

		

		for (int i = 0; i<numberMaterials; i++){

			materials[i] = getName();

			category = getCategory();

			quantity = getQuantity();

			
			homeCenter[i]= getPrice(place1)*quantity;

		
			ferreteriaCentro[i]=getPrice(place2)*quantity;

			
			ferreteriaBarrio[i]=getPrice(place3)*quantity;


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
			op.asignPlace(numberMaterials, designStage, materials, bestPrice, bestPlace);


			System.out.println("Materiales de OBRA BLANCA:  ");
			op.asignPlace(numberMaterials, postConstruction, materials, bestPrice, bestPlace);


			System.out.println("Materiales de PINTURA:  ");
			op.asignPlace(numberMaterials, paint, materials, bestPrice, bestPlace);



       total = op.sumTotal(bestPrice, location);
       System.out.println("Con los mejores precios el total a pagar es de  " + (total + DESIGN_STAGE + POST_CONSTRUCTION + PAINT));

       total = op.sumTotal(homeCenter, location);
       System.out.println("Si todo se compra en Home Center el total es de   " + (total + DESIGN_STAGE + POST_CONSTRUCTION + PAINT));

       total = op.sumTotal(ferreteriaBarrio, location);
       System.out.println("Si todo se compra en Ferreteria del Barrio el total es de   " + (total + DESIGN_STAGE + POST_CONSTRUCTION + PAINT));

       total = op.sumTotal(ferreteriaCentro, location);
       System.out.println("Si todo se compra en Ferreteria del Centro el total es de   " + (total + DESIGN_STAGE + POST_CONSTRUCTION + PAINT));


	}
}	
