package week7.요리교실;

public class TomatoEggFriedRiceClass extends CookingClass{
    @Override
    protected void prepareIngredients() {
        System.out.println("재료: 밥, 토마토, 계란, 마늘, 대파, 간장, 식용유를 준비해요.");
    }
    @Override
    protected void preCook() {
        System.out.println("--고슬고슬 밥을 준비해요");
        System.out.println("--마늘은 다지지않고 얇게 썰어요");
        System.out.println("--토마토는 썰고 계란은 풀어요~");
        System.out.println("--대파를 조금 잘게 썰어두어요~");
    }

 
    @Override
    protected void mainCook() {
        System.out.println("--기름을 두르고 대파와 마늘을 넣고 볶아서 풍미를 높여요");
        System.out.println("--토마토와 밥을 함께 볶은 후 한쪽으로 몰아요");
        System.out.println("--팬 한쪽에서 계란을 스크램블한 후 섞으면 원팬요리가 되죠~!");
        System.out.println("--부족한 간은 간장으로 조금넣어 맞춰요~");
    }

    @Override
    protected void plate() {
        System.out.println("--접시에 둥글게 펼져서 담고, 대파를 쫑쫑 썰어서 솔솔 뿌려요!");
    }

}
