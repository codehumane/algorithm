package basic.tree

class MinHeap(maxSize: Int) {

    companion object {
        const val ROOT_INDEX = 1
    }

    // 편의상 index를 1부터 시작하기 위해, 크기를 maxSize + 1로 설정
    private val array: Array<Int?> = arrayOfNulls(maxSize + 1)

    // 마찬가지로, index를 1부터 시작하기 위해, 초기 값으로 0을 설정
    private var lastIndex = 0

    internal fun leftChildIndexOf(index: Int) = index * 2

    internal fun rightChildIndexOf(index: Int) = leftChildIndexOf(index) + 1

    internal fun parentIndexOf(index: Int) = index / 2

    fun root(): Int? = array[1]

    fun leftChildOf(index: Int) = array[leftChildIndexOf(index)]

    fun rightChildOf(index: Int) = array[leftChildIndexOf(index) + 1]

    fun insert(element: Int) {
        // 일단, 마지막 단계의 가장 오른쪽에 삽입
        array[++lastIndex] = element
        // 자신 보다 큰 부모가 있다면 계속 자리 교환
        swapWithGreaterParents(element, lastIndex)
    }

    private fun swapWithGreaterParents(element: Int, elementIndex: Int) {
        val parentIndex = parentIndexOf(elementIndex)
        if (array[parentIndex] == null) return
        if (array[parentIndex]!! <= element) return
        swap(array, parentIndex, elementIndex)
        swapWithGreaterParents(element, parentIndex)
    }

    private fun swap(array: Array<Int?>, i1: Int, i2: Int) {
        val temp = array[i1]
        array[i1] = array[i2]
        array[i2] = temp
    }

    fun extract(): Int {
        TODO()
    }

}