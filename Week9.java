import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
//import Đỗ Quang Thịnh

public class Week9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Dùng ArrayList để lưu danh sách ban đầu
        System.out.println("Nhap danh sach cac so nguyen: ");
        String input = sc.nextLine();
        String[] inputArray = input.split(" ");
        sc.close();
        ArrayList<Integer> numbersList = new ArrayList<>();
        for (String number : inputArray) {
            numbersList.add(Integer.valueOf(number));
        }

        Collections.sort(numbersList);  // Sử dụng hàm sort để xếp dãy tăng dần

        // Sử dụng HashMap để lưu các giá trị kèm theo số lần xuất hiện của nó
        HashMap<Integer, Integer> freqNumber = new HashMap<>(); 
        for (int number: numbersList) {
            freqNumber.put(number, freqNumber.getOrDefault(number, 0) + 1);
            // Lệnh bên trên tương đương với
            // freqNumber.put(number, freqNumber.get(number) == null ? 1 : freqNumber.get(number) + 1);
        }

        // In cách 1:
        /*
        Tư tưởng là tìm số nào xuất hiện nhiều nhất -> đó là số dòng cần in ra
        Mỗi 1 dòng thì check xem số lần xuất hiện của số đó có lớn hơn bằng số dòng hiện tại không
        Nếu số lần xuất hiện lớn hơn số dòng hiện tại thì in ra số đó, ngược lại in ra là dấu cách
        */
        int maxCount = 0;
        System.out.println("Cach 1:");

        for (int key: freqNumber.keySet()) {
            maxCount = maxCount > freqNumber.get(key) ? maxCount : freqNumber.get(key);
        }
        for (int i = 1; i <= maxCount; i++){
            for (int key: freqNumber.keySet()){
                if (freqNumber.get(key) >= i) {
                    System.out.print(key);
                }
                else{               // In dấu cách theo số lượng chữ số để khi in các số thẳng hàng
                    int temp = key;
                    while (temp > 0) {  
                        temp /= 10;
                        System.out.print(" ");
                    }
                }
                System.out.print(" ");
            }
            System.out.print("\n");
        }

        // Cách 2 chỉ đơn giản là in mỗi dòng 1 số theo số lượng xuất hiện của số đó
        System.out.println("Cach 2: ");
        for (int key: freqNumber.keySet()) {
            for (int i = 0; i < freqNumber.get(key); i++) {
                System.out.print(key + " ");
            }
            System.out.print("\n");
        }
    }
}
