package quiz;

/**
 * 이항 계수 (https://ko.wikipedia.org/wiki/%EC%9D%B4%ED%95%AD%EA%B3%84%EC%88%98) <br/>
 * 간단 정의: 서로 다른 정수 N개에서 R개를 뽑을 때 가능한 경우의 수 <br/>
 * 파스칼의 법칙에 의하면 다음의 점화식이 성립: F(N,K) = F(N-1,K) + F(N-1,K-1) <br/>
 */
public interface BinomialCoefficient {

    /**
     * 서로 다른 정수 N개에서 R개를 뽑을 때 가능한 경우의 수를 구한다.
     *
     * @param N 서로 다른 정수 갯수
     * @param K 뽑아야 하는 정수의 갯수
     * @return
     */
    int calculate(int N, int K);
}
