public class test {
    public static double calculateDamage (int baseAttack, double multiplier){
        double damage = baseAttack * multiplier;
        return damage;
    }
    public static double calculateDamage (int attack, int weaponBonus, int critBonus){
        int totalDamage = attack + weaponBonus + critBonus;
        return totalDamage;
    }
    public static void main (String [] args){
        double result = calculateDamage(10,1.5);
        System.out.println(result);
        double result1 = calculateDamage(20,5,10);
        System.out.println(result1);


    }
}