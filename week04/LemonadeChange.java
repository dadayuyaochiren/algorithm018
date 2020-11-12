import javax.swing.text.StyledEditorKit;

/**
 * 柠檬 找零
 *  思路 零钱 :  5元  10元
 *       找零贪心思路:   20 优先找零 10,5
 */
public class LemonadeChange {


    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int money : bills){
            if (five < 0 ) return false;
           switch (money){
               case 5 :
                   five++;
                   break;
               case 10:
                   five--;
                   ten++;
                   break;
               case 20:
                   if (ten>0){
                       ten--;
                       five--;
                   }else{
                       five= five-3;
                   }
                   break;
           }
        }
        if (five < 0 ) return false;
        return true;
    }


    public static void main(String[] args) {
        LemonadeChange l = new LemonadeChange();
        System.out.println(l.lemonadeChange(new int[]{5, 5, 10, 10, 20}));

    }

}
