import javax.xml.transform.Source;
import java.util.HashMap;
import java.util.Scanner;

//======================================================================================================================
//======================================================================================================================
class Jewellery {
    private String id ;
    private String type;
    private String material;
    private int price;

//==============================================NoArgs CONSTRUCTOR======================================================
    public Jewellery(){

    }

//===================================================CONSTRUCTOR========================================================
    public Jewellery(String id, String type, String material, int price) {
        this.id = id;
        this.type = type;
        this.material = material;
        this.price = price;
    }
//======================================================GETTERS=========================================================
    public String getId() {
        return id;
    }

    public String getMaterial() {
        return material;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }
//========================================================SETTERS=======================================================

    public void setId(String id) {
        this.id = id;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(int price) {
        this.price = price;
    }

//======================================================================================================================
//======================================================================================================================

}

class JewelleryUtility {

    public HashMap<String ,String> getJewelleryDetails(String id){
        HashMap<String,String> resultMap =new HashMap<>();
        if (Program.jewelleryDetailsMap.containsKey(id)){
            resultMap.put(id,Program.jewelleryDetailsMap.get(id).getType()+"_"+Program.jewelleryDetailsMap.get(id).getMaterial());
        }
        return resultMap;
    }

    public HashMap<String, Jewellery> updateJewelleryPrice(String id, int price){
        HashMap<String,Jewellery> resultMap =new HashMap<>();
        if (Program.jewelleryDetailsMap.containsKey(id)){
            Program.jewelleryDetailsMap.get(id).setPrice(price);
            Jewellery j = Program.jewelleryDetailsMap.get(id);
            resultMap.put(id,j);
        }
        return resultMap;
    }
}



public class Program{

    public static HashMap<String,Jewellery> jewelleryDetailsMap = new HashMap<>();
    public static Scanner sc = new Scanner(System.in);
    public static JewelleryUtility jewelleryUtility = new JewelleryUtility();

    public static void AddJewels(){
        System.out.println("enter the ID: ");
        String idScan = sc.nextLine();
        System.out.println("enter the Type: ");
        String typeScan = sc.nextLine();
        System.out.println("enter the Material: ");
        String materialScan = sc.nextLine();
        System.out.println("enter the Price: ");
        int priceScan = Integer.parseInt(sc.nextLine());

        jewelleryDetailsMap.put(idScan,new Jewellery(idScan,typeScan,materialScan,priceScan));
    }
    public static void main() {



        boolean exit = false;
         while(!exit){
             System.out.println("1. Get Jewellery Details\n" +
                     "2. Update Price\n" +
                     "3. Add Jewel\n"+
                     "4. Exit");

             int choice =Integer.parseInt(sc.nextLine());

             if (choice==4){
                 System.out.println("Exiting the Program.....");
                 exit= true;
                 break;
             }
             else if (choice==2){
                 System.out.println("Enter the Id: ");
                 String scanId = sc.nextLine();
                 System.out.println("Enter the Price: ");
                 int scanPrice= Integer.parseInt(sc.nextLine());
                 System.out.println(jewelleryUtility.updateJewelleryPrice(scanId,scanPrice));

             }else if (choice==1){
                 System.out.println("Enter the Id: ");
                 String scanId = sc.nextLine();
                 System.out.println(jewelleryUtility.getJewelleryDetails(scanId));
             }
             else if (choice==3){
                AddJewels();
             }
         }
    }
}
