import com.mascloud.sdkclient.Client;
import java.util.*;

public class masTest {

    private static Client client = null;
    private static HashMap<String, String[]> map = new HashMap<String, String[]>();

    static {
        if (client == null) {
            client = Client.getInstance();
            boolean step = client.login("http://mas.ecloud.10086.cn/app/sdk/login", "zwfwzx01", "zwfwzx123", "长沙市政务服务中心");
            if (!step) {
                client = null;
            }
        }
    }

    public static void main(String[] args) {
        try {
            //final Client client =  Client.getInstance();
            //boolean step=client.login("http://mas.ecloud.10086.cn/app/sdk/login", "zwfwzx01", "zwfwzx123","长沙市政务服务中心");
            //--
//            String[] numbers = {"13974821154", "15974144388", "13517317857", "18608400531", "13873155605", "13787159737", "13873174604",
//                    "13574873285", "18627303051", "15973136918", "18573207700", "15873164898", "18313132945", "13723880722", "13739055200", "13807492015", "13739055997", "18774093634"
//            };
            String[] numbers ={"18670723557","17673167159"};
            String caseid = "20170756234";
            int sendResult = client.sendDSMS(numbers, "收到后请在群内发送给我们， 测试工单:！" + caseid, "", 1, "dxky0mI9", UUID.randomUUID().toString(), true);

            //定时器
//            map.put(id, num);
//            Timer t = new Timer(); // 建立Timer对象
//            t.schedule(new MyTask(), 1000L, 10 * 1000L);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class MyTask extends TimerTask {
        @Override
        public void run() {
            if (map.size() == 0) {
                return;
            }
            //System.out.println("map大小" + map.size());
            Set<Map.Entry<String, String[]>> set = map.entrySet();// 取得键值对的对象set集合
            for (Map.Entry<String, String[]> en : set) {// 遍历键值对的集合
                //System.out.println(en.getValue() + "       " + en.getKey());// 通过键值对对象，取得里面的值
                client.sendDSMS(en.getValue(), "小伙子们今晚打老虎！,暗号为：" + en.getKey(), "", 1, "dxky0mI9", UUID.randomUUID().toString(), true);
            }
        }
    }

}
