package code;

import java.util.Random;

public class Map {
	private int insert;
	public void printmap(int[][] gamemap,int MAPSIZE){
		for(int i=0;i<MAPSIZE;i++){
			for(int j=0;j<MAPSIZE;j++){
				System.out.println(gamemap[i][j]);
			}
			//System.out.println();
		}
	}

	public void gen(int MAPSIZE){
		int[][] gamemap = new int[MAPSIZE][MAPSIZE];
		int a = 0;
		Random rand = new Random();
		for(int x = 0;x<MAPSIZE;x++){
			for(int y=0;y<MAPSIZE;y++){
				insert = rand.nextInt((3-1)+1)+1;
				if(insert==3){
					insert += rand.nextInt((350-100)+1)+100;
				}
				gamemap[x][y] = insert;				
			}
		}
		printmap(gamemap,MAPSIZE);
		/*for(int i=0;i < MAPSIZE;i++){
			insert = rand.nextInt((3-1)+1)+1;
			if(insert > 2){
				insert += rand.nextInt((399-100)+1)+100;
			}
			gamemap[i][a] = insert;
			if(i==MAPSIZE){
				if (a==MAPSIZE){
					break;
				}
				i = 0;
				a++;
				
			}*/
			
		
		
		
	}
	public void render(){
		
	}
}
