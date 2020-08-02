package hackerrank.linkedlist

fun reverseDoublyLinkedListNode(llist: DoublyLinkedListNode?): DoublyLinkedListNode? {
    var temp: DoublyLinkedListNode? = null
    var node = llist

    while (node != null) {
        node.prev = node.next
        node.next = temp
        temp = node
        if (node.prev == null) break
        node = node.prev
    }

    return node
}

data class DoublyLinkedListNode(
    val data: Int,
    var prev: DoublyLinkedListNode? = null,
    var next: DoublyLinkedListNode? = null
) {
    override fun toString() = "DoublyLinkedListNode(data=$data)"
}
