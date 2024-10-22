package unresolved;//
////  평점 변환953215468831
//
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class unresolved.BOJ31799 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(br.readLine());
//        String str = br.readLine();
//        int[] score = new int[N];
//
//        int j = 0;
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == 'A') {
//                if (i == N - 1) {
//                    score[j] = 8;
//                    break;
//                }
//                if (str.charAt(i + 1) == '+') {
//                    score[j] = 9;
//                    j++;
//                }
//                if (str.charAt(i + 1) == '-') {
//                    score[j] = 7;
//                    j++;
//                }
//                if (str.charAt(i + 1) != '-' && str.charAt(i + 1) != '+') {
//                    score[j] = 8;
//                    j++;
//                }
//            }
//
//            if (str.charAt(i) == 'B') {
//                if (i == N - 1) {
//                    score[j] = 5;
//                    break;
//                }
//                if (str.charAt(i + 1) == '+') {
//                    score[j] = 6;
//                    j++;
//                }
//                if (str.charAt(i + 1) == '-') {
//                    score[j] = 4;
//                    j++;
//                }
//                if (str.charAt(i + 1) != '-' && str.charAt(i + 1) != '+') {
//                    score[j] = 5;
//                    j++;
//                }
//            }
//
//            if (str.charAt(i) == 'C') {
//                if (i == N - 1) {
//                    score[j] = 2;
//                    break;
//                }
//                if (str.charAt(i + 1) == '+') {
//                    score[j] = 3;
//                    j++;
//                }
//                if (str.charAt(i + 1) == '-') {
//                    score[j] = 1;
//                    j++;
//                }
//                if (str.charAt(i + 1) != '-' && str.charAt(i + 1) != '+') {
//                    score[j] = 2;
//                    j++;
//                }
//            }
//
//        }
//
//        StringBuilder result = new StringBuilder();
//
//        for (int i = 0; i < N; i++) {
//            if (score[i] == 9) {
//                result.append("E");
//            }
//
//            if (score[i] == 8) {
//                if (i == 0) {
//                    result.append("E");
//                    continue;
//                }
//                if (score[i - 1] < score[i]) {
//                    result.append("E");
//                } else {
//                    result.append("P");
//                }
//            }
//
//            if (score[i] == 7 || score[i] == 6) {
//                if (i == 0) {
//                    result.append("P");
//                }
//                if (score[i - 1] > 6) {
//                    result.append("D");
//                } else {
//                    result.append("P");
//                }
//            }
//
//            if (score[i] == 5 || score[i] == 4) {
//                if (i == 0) {
//                    result.append("D");
//                }
//                if (score[i - 1] > 3) {
//                    result.append("B");
//                } else {
//                    result.append("D");
//                }
//            }
//
//            if (score[i] == 1 || score[i] == 2 || score[i] == 3) {
//                result.append("B");
//            }
//
//
//        }
//        System.out.println(result);
//    }
//}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ31799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());  // 학기 수 입력
        String str = br.readLine();  // 기존 평어 체제의 문자열 입력
        int[] score = new int[N];  // 점수를 저장할 배열
        int j = 0;  // 점수를 저장할 인덱스

        // 기존 평어를 숫자로 변환
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'A') {
                if (i < N - 1 && str.charAt(i + 1) == '+') {
                    score[j++] = 9;
                    i++;
                } else if (i < N - 1 && str.charAt(i + 1) == '-') {
                    score[j++] = 7;
                    i++;
                } else {
                    score[j++] = 8;
                }
            } else if (str.charAt(i) == 'B') {
                if (i < N - 1 && str.charAt(i + 1) == '+') {
                    score[j++] = 6;
                    i++;
                } else if (i < N - 1 && str.charAt(i + 1) == '-') {
                    score[j++] = 4;
                    i++;
                } else {
                    score[j++] = 5;
                }
            } else if (str.charAt(i) == 'C') {
                if (i < N - 1 && str.charAt(i + 1) == '+') {
                    score[j++] = 3;
                    i++;
                } else if (i < N - 1 && str.charAt(i + 1) == '-') {
                    score[j++] = 1;
                    i++;
                } else {
                    score[j++] = 2;
                }
            }
        }

        StringBuilder result = new StringBuilder();  // 결과 저장할 StringBuilder

        // 첫 번째 학기 처리
        for (int i = 0; i < N; i++) {
            if (score[i] == 9) {
                result.append("E");
            } else if (score[i] == 8) {
                if (i == 0) {
                    result.append("E");
                } else if (score[i - 1] < 8) {
                    result.append("E");
                } else {
                    result.append("P");
                }
            } else if (score[i] == 7 || score[i] == 6) {
                if (i == 0) {
                    result.append("P");
                } else if (score[i - 1] > 6) {
                    result.append("D");
                } else {
                    result.append("P");
                }
            } else if (score[i] == 5 || score[i] == 4) {
                if (i == 0) {
                    result.append("D");
                } else if (score[i - 1] > 3) {
                    result.append("B");
                } else {
                    result.append("D");
                }
            } else if (score[i] == 1 || score[i] == 2 || score[i] == 3) {
                result.append("B");
            }
        }

        // 결과 출력
        System.out.println(result.toString());
    }
}