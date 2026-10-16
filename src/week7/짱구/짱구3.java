package week7.짱구;

import java.util.Map;
import java.util.HashMap;

public class 짱구3 {
    private Map<String, IBehaviorStrategy> strategyMap = new HashMap<>();
    //"엄마", "아빠", "선생님", "친구들" 처럼 대상에 따라 다른 매너를 취한다면 
    // 역시 key 와 전략으로 매핑하면 됩니다.
    public 짱구3() {
        strategyMap.put("심부름", new SleepStrategy());
        strategyMap.put("울고", new ActionMaskStrategy());
        strategyMap.put("춤", new DanceStrategy());
        strategyMap.put("엉덩이", new DanceStrategy());
        strategyMap.put("방귀 ", new DanceStrategy());
    }
    
    public void encounterSituation(String context) {
        for (String keyword : strategyMap.keySet()) {
            if (context.contains(keyword)) {
                strategyMap.get(keyword).behave(context);
                return;
            }
        }

        System.out.println("짱구는 아무 생각이 없습니다....");
    }
}

