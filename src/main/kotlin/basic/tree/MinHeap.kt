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
        swapWithBiggerParents(element, lastIndex)
    }

    private fun swapWithBiggerParents(element: Int, elementIndex: Int) {
        val parentIndex = parentIndexOf(elementIndex)
        if (array[parentIndex] == null) return
        if (array[parentIndex]!! <= element) return
        swap(array, parentIndex, elementIndex)
        swapWithBiggerParents(element, parentIndex)
    }

    fun extract(): Int? {

        // 루트에서 제거
        val extracted = array[ROOT_INDEX] ?: return null

        // 가장 아래 우측 원소를 부모로 위치시킴
        array[ROOT_INDEX] = null
        swap(array, ROOT_INDEX, lastIndex)
        lastIndex--

        // 부모로 위치시킬 원소가 없다면, 루트에서 제거한 값을 그대로 반환
        if (array[ROOT_INDEX] == null) return extracted

        // 임의로 위치시킨 부모를, 자신 보다 큰 자식을 만나기 전까지 자식과의 위치 교환
        swapWithSmallerChildren(array[ROOT_INDEX]!!, ROOT_INDEX)

        return extracted
    }

    private fun swapWithSmallerChildren(element: Int, elementIndex: Int) {

        // 자식 중에 더 작은 값 고르기
        val left = leftChildOf(elementIndex) ?: return
        val right = rightChildOf(elementIndex) ?: Int.MAX_VALUE
        val smallerIndex = if (left < right) leftChildIndexOf(elementIndex)
        else rightChildIndexOf(elementIndex)

        // 선택된 자식보다 부모가 작으면 자리 교환
        if (element > array[smallerIndex]!!) {
            swap(array, elementIndex, smallerIndex)
            swapWithSmallerChildren(element, smallerIndex)
        }
    }

    private fun swap(array: Array<Int?>, i1: Int, i2: Int) {
        val temp = array[i1]
        array[i1] = array[i2]
        array[i2] = temp
    }

    fun toArray(): Array<Int?> {
        return array.copyOfRange(1, lastIndex + 1)
    }

}