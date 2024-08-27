class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        int attackNum = 0;
        int healthTime = 0;
        int currentHealth = health;
        
        for(int i=1;i<=attacks[attacks.length-1][0];i++){
            
            //몬스터 공격 시간이 됐을 경우
            if(attacks[attackNum][0]==i){
                currentHealth = currentHealth - attacks[attackNum][1];
                healthTime = 0;
                if (currentHealth <= 0) {
                    return -1;
                }
                attackNum = attackNum+1;
            }
            //몬스터 공격 시간이 아닌 경우
            else{
                currentHealth = currentHealth + bandage[1];
                healthTime = healthTime + 1; 
                
                if(healthTime==bandage[0]){
                    currentHealth = currentHealth + bandage[2];
                    healthTime = 0;
                }
                if(currentHealth > health){currentHealth = health;}   
            }   
        }
        return currentHealth;
    }
}