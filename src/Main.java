import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 도시의 개수 (정점)
        int m = sc.nextInt(); // 버스의 개수 (간선)
        int INF = 100000000; // 무한대 값 설정 (충분히 큰 값)

        int[][] dist = new int[n + 1][n + 1];

        // 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = INF;
                }
            }
        }

        // 간선 정보 입력
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            dist[a][b] = Math.min(dist[a][b], c); // 중복 간선 처리
        }

        // 플로이드-워셜 알고리즘
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // 결과 출력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("0 "); // 경로가 없는 경우
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }

        sc.close();
    }
}
