/* 反復子 */
interface Iteration {
    /* 反復子の終了判定 */
    /* @return boolean true:継続 false:終了 */
    boolean hasNext();
}

/* Objectに関する反復子 */
interface ObjectIteration extends Iteration {
    /* 一段階の処理を行い、反復を1つ前進させ、処理結果を返す */
    /* @return java.lang.Object 処理結果 */
    Object next();
}
