package com.zoo.sim;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Zoo Class
 *
 */
public class Zoo {

    private ArrayList<LandAnim> landList = new ArrayList<LandAnim>();
    private ArrayList<BirdAnim> birdList = new ArrayList<BirdAnim>();
    private ArrayList<WaterAnim> waterList = new ArrayList<WaterAnim>();
    private ArrayList<ZooObj> objList = new ArrayList<ZooObj>();
    private ArrayList<Animal> list = new ArrayList<Animal>();

    /**
     * Constructor throws IOException
     */
    public Zoo() throws IOException {
        loadAnimals();
        loadObject();

    }

    /**
     * Load Animals throws IOException
     */
    private void loadAnimals() throws IOException {
        //
        String delimiter = ",";
        String line;
        String[] headers;
        String[] animalData;
        //initialize
        Animal animal = new Animal();

        //
        BufferedReader reader = new BufferedReader(new FileReader("AnimalData.csv"));
        //header - first line
        line = reader.readLine();
        //System.out.println(line);
        headers = line.split(delimiter);
        //animal data
        line = reader.readLine();
        while (line != null) {
            //System.out.println(line);

            if (line.startsWith(ZooConfig.KEY_LAND)) {
                animal = new LandAnim();
            } else if (line.startsWith(ZooConfig.KEY_BIRD)) {
                animal = new BirdAnim();
            } else if (line.startsWith(ZooConfig.KEY_WATER)) {
                animal = new WaterAnim();
            }

            // initialize position and image
            animal.setPosition(new Point(0, 0));
            animal.setImage(new Image(0, 0));
            // delimit the data
            animalData = line.split(delimiter);
            for (int i = 0; i < headers.length; i++) {
                switch (headers[i]) {
                    case ZooConfig.HEADER_ID:
                        animal.setId(animalData[i].trim());
                        break;
                    case ZooConfig.HEADER_NAME:
                        animal.setName(animalData[i].trim());
                        break;
                    case ZooConfig.HEADER_SPECIES:
                        animal.setSpecies(animalData[i].trim());
                        break;
                    case ZooConfig.HEADER_SEX:
                        animal.setSex(animalData[i].trim().charAt(0));
                        break;
                    case ZooConfig.HEADER_AGE:
                        animal.setAge(Integer.parseInt(animalData[i].trim()));
                        break;
                    case ZooConfig.HEADER_POS_X:
                        animal.setPositionX(Integer.parseInt(animalData[i].trim()));
                        break;
                    case ZooConfig.HEADER_POS_Y:
                        animal.setPositionY(Integer.parseInt(animalData[i].trim()));
                        break;
                    case ZooConfig.HEADER_SIZE:
                        animal.setSize(animalData[i].trim().charAt(0));
                        break;
                    case ZooConfig.HEADER_SPEED:
                        animal.setSpeed(Integer.parseInt(animalData[i].trim()));
                        break;
                    case ZooConfig.HEADER_DIRECT:
                        animal.setDirection(Integer.parseInt(animalData[i].trim()));
                        break;
                    case ZooConfig.HEADER_HUNGER:
                        animal.setHunger(Integer.parseInt(animalData[i].trim()));
                        break;
                    case ZooConfig.HEADER_FATIGUE:
                        animal.setFatigue(Integer.parseInt(animalData[i].trim()));
                        break;
                    case ZooConfig.HEADER_IMAGE_W:
                        animal.getImage().setWidth(Integer.parseInt(animalData[i].trim()));
                        break;
                    case ZooConfig.HEADER_IMAGE_H:
                        animal.getImage().setHeight(Integer.parseInt(animalData[i].trim()));
                        break;
                    case ZooConfig.HEADER_SOUND:
                        animal.setSound(animalData[i].trim());
                        break;
                    case ZooConfig.HEADER_CAN_FLY:
                        if (!animalData[i].equals(ZooConfig.VALUE_NA)) {
                            ((BirdAnim) animal).setCanFly(Boolean.parseBoolean(animalData[i].trim()));
                        }
                        break;
                    case ZooConfig.HEADER_CAN_BREATHE:
                        if (!animalData[i].equals(ZooConfig.VALUE_NA)) {
                            ((WaterAnim) animal).setCanBreathe(Boolean.parseBoolean(animalData[i].trim()));
                        }
                        break;
                }
            }

            // add to list
            if (animal.getId().startsWith(ZooConfig.KEY_LAND)) {
                LandAnim landAnimal = (LandAnim) animal;
                landList.add(landAnimal);
            } else if (animal.getId().startsWith(ZooConfig.KEY_BIRD)) {
                BirdAnim birdAnimal = (BirdAnim) animal;
                birdAnimal.setCanFly(true);
                birdList.add(birdAnimal);
            } else if (animal.getId().startsWith(ZooConfig.KEY_WATER)) {
                WaterAnim waterAnimal = (WaterAnim) animal;
                waterAnimal.setCanBreathe(true);
                waterList.add(waterAnimal);
            }
            list.add(animal);

            // read next line
            line = reader.readLine();
        }
        reader.close();	//close reader
    }

    /**
     * Load Zoo Objects throws IOException
     */
    private void loadObject() throws IOException {
        //
        String delimiter = ",";
        String line;
        String[] headers;
        String[] objData;
        ZooObj obj;

        //
        BufferedReader reader = new BufferedReader(new FileReader("ZooObjects.csv"));
        //header - first line
        line = reader.readLine();
        headers = line.split(delimiter);
        //first data line
        line = reader.readLine();
        while (line != null) {
            obj = new ZooObj();
            // initialize point
            obj.setPosition(new Point(0, 0));
            // store data into string array
            objData = line.split(delimiter);
            for (int i = 0; i < headers.length; i++) {
                switch (headers[i]) {
                    case ZooConfig.HEADER_ID:
                        obj.setId(objData[i].trim());
                        break;
                    case ZooConfig.HEADER_TYPE:
                        obj.setType(objData[i].trim());
                        break;
                    case ZooConfig.HEADER_POS_X:
                        obj.setPositionX(Integer.parseInt(objData[i].trim()));
                        break;
                    case ZooConfig.HEADER_POS_Y:
                        obj.setPositionY(Integer.parseInt(objData[i].trim()));
                        break;
                    case ZooConfig.HEADER_SIZE:
                        obj.setSize(objData[i].trim().charAt(0));
                        break;
                }
            }
            //add to arrayList
            objList.add(obj);

            // read next line
            line = reader.readLine();
        }
        reader.close();	//close reader
    }

    /**
     * Display Summary of Animals
     */
    public void listAnimals() {
        System.out.println("-------------------");
        System.out.println("Summary of Animals:");
        System.out.println("-------------------");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(((Animal) list.get(i)).toString());
        }
    }

    /**
     * Display All Animals Details
     */
    public void displayAnimals() {
        displayLandAnimals();
        displayBirdAnimals();
        displayWaterAnimals();
    }

    /**
     * Display Land Animals Details
     */
    public void displayLandAnimals() {
        System.out.println("-------------");
        System.out.println("Land Animals:");
        System.out.println("-------------");
        for (int i = 0; i < landList.size(); i++) {
            System.out.println(((LandAnim) landList.get(i)).toDetailString());
        }
    }

    /**
     * Display Bird Animals Details
     */
    public void displayBirdAnimals() {
        System.out.println("-------------");
        System.out.println("Bird Animals:");
        System.out.println("-------------");
        for (int i = 0; i < birdList.size(); i++) {
            System.out.println(((BirdAnim) birdList.get(i)).toDetailString());
        }
    }

    /**
     * Display Water Animals Details
     */
    public void displayWaterAnimals() {
        System.out.println("--------------");
        System.out.println("Water Animals:");
        System.out.println("--------------");
        for (int i = 0; i < waterList.size(); i++) {
            System.out.println(((WaterAnim) waterList.get(i)).toDetailString());
        }
    }

    /**
     * Display Summary of Zoo Objects
     */
    public void listObjects() {
        System.out.println("-----------------------");
        System.out.println("Summary of Zoo Objects:");
        System.out.println("-----------------------");
        for (int i = 0; i < objList.size(); i++) {
            System.out.println(((ZooObj) objList.get(i)).toString());
        }
    }

    /**
     * Display Zoo Objects
     */
    public void displayObjects() {
        System.out.println("------------");
        System.out.println("Zoo Objects:");
        System.out.println("------------");
        for (int i = 0; i < objList.size(); i++) {
            System.out.println(((ZooObj) objList.get(i)).toDetailString());
        }
    }

    /**
     * List All Hungry Animals
     */
    public void listHungryAnimals() {
        boolean find = false;
        Animal animal;
        System.out.println("---------------");
        System.out.println("Hungry Animals:");
        System.out.println("---------------");
        for (int i = 0; i < list.size(); i++) {
            animal = (Animal) list.get(i);
            if (animal.getHunger() > 5) {
                System.out.println(animal.toString() + "\t\t" + ZooConfig.HEADER_HUNGER + ": " + animal.getHunger());
                find = true;
            }
        }
        if (!find){
            System.out.println("There are currrently no hungry animals.");
        }
    }

    /**
     * Feed All Hungry Animals
     */
    public void feedHungryAnimals() {
        boolean find = false;
        Animal animal;
        System.out.println("------------");
        System.out.println("Feed Animals:");
        System.out.println("------------");
        for (int i = 0; i < list.size(); i++) {
            animal = (Animal) list.get(i);
            if (animal.getHunger() > 5) {
                System.out.println(animal.toString());
                animal.eat();
                find = true;
            }
        }
        if (!find){
            System.out.println("There are currrently no hungry animals.");
        }
    }

    /**
     * List All Tired Animals
     */
    public void listTiredAnimals() {
        boolean find = false;
        Animal animal;
        System.out.println("--------------");
        System.out.println("Tired Animals:");
        System.out.println("--------------");
        for (int i = 0; i < list.size(); i++) {
            animal = (Animal) list.get(i);
            if (animal.getFatigue() > 5) {
                System.out.println(animal.toString() + "\t\t" + ZooConfig.HEADER_FATIGUE + ": " + animal.getFatigue());
                find = true;
            }
        }
        if (!find){
            System.out.println("There are currently no tired animals.");
        }
    }

    /**
     * Make All Tired Animals Sleep
     */
    public void restTiredAnimals() {
        boolean find = false;
        Animal animal;
        System.out.println("-------------------");
        System.out.println("Make Animals Sleep:");
        System.out.println("-------------------");
        for (int i = 0; i < list.size(); i++) {
            animal = (Animal) list.get(i);
            if (animal.getFatigue() > 5) {
                System.out.println(animal.toString());
                animal.sleep();
                find = true;
            }
        }
        if (!find){
            System.out.println("There are currently no tired animals.");
        }
    }

    /**
     * Move All Animals
     */
    public void moveAnimals() {
        moveLandAnimals();
        moveBirdAnimals();
        moveWaterAnimals();
    }

    /**
     * Move Land Animals
     */
    public void moveLandAnimals() {
        LandAnim animal;
        System.out.println("------------------");
        System.out.println("Move Land Animals:");
        System.out.println("------------------");
        for (int i = 0; i < landList.size(); i++) {
            animal = (LandAnim) landList.get(i);
            System.out.println(animal.toString());
            animal.move();
            animal.makeSound();
        }
    }

    /**
     * Move Bird Animals
     */
    public void moveBirdAnimals() {
        BirdAnim animal;
        System.out.println("------------------");
        System.out.println("Move Bird Animals:");
        System.out.println("------------------");
        for (int i = 0; i < birdList.size(); i++) {
            animal = (BirdAnim) birdList.get(i);
            System.out.println(animal.toString());
            animal.move();
            animal.makeSound();
        }
    }

    /**
     * Move Water Animals
     */
    public void moveWaterAnimals() {
        WaterAnim animal;
        System.out.println("-------------------");
        System.out.println("Move Water Animals:");
        System.out.println("-------------------");
        for (int i = 0; i < waterList.size(); i++) {
            animal = (WaterAnim) waterList.get(i);
            System.out.println(animal.toString());
            animal.move();
            animal.makeSound();
        }
    }

    /**
     * Turn Land Animal
     */
    public void turnLandAnimals() {
        LandAnim animal;
        System.out.println("------------------");
        System.out.println("Turn Land Animals:");
        System.out.println("------------------");
        for (int i = 0; i < landList.size(); i++) {
            animal = (LandAnim) landList.get(i);
            System.out.println(animal.toString());
            animal.turn((int)(360*Math.random()));
            animal.makeSound();
        }
    }
    
    /**
     * Turn Bird Animal
     */
    public void turnBirdAnimals() {
        BirdAnim animal;
        System.out.println("------------------");
        System.out.println("Turn Bird Animals:");
        System.out.println("------------------");
        for (int i = 0; i < birdList.size(); i++) {
            animal = (BirdAnim)birdList.get(i);
            System.out.println(animal.toString());
            animal.turn((int)(360*Math.random()));
            animal.makeSound();
        }
    }
    
    /**
     * Turn Water Animals
     */
    public void turnWaterAnimals() {
        WaterAnim animal;
        System.out.println("-------------------");
        System.out.println("Turn Water Animals:");
        System.out.println("-------------------");
        for (int i = 0; i < waterList.size(); i++) {
            animal = (WaterAnim)waterList.get(i);
            System.out.println(animal.toString());
            animal.turn((int)(360*Math.random()));
            animal.makeSound();
        }
    }
}

/* How would you modify this structure to allow for predator/prey interactions and Carnivores/Omnivores/Herbivores
Define new fields to the Animal Class to assign values of either Carnivore, Omnivore, or Herbivore
Add a new method to find Animal object by using Animal IDs
Add a method to describe an interaction between two given animal IDs
 - Find the distance between the two animals
 - Find the direction of the two animals
 - If distance is close enough to see each other, turn both of the animals to face each other
 Based on their diet type, decide the options of predatory/prey interactions 
    - Example: Carnivores will try to eat Herbivores
    - Example: Herbivores will not try to eat other Herbivores
    - Example: Omnivores will try to eat either Herbivores or Carnivores
*/
