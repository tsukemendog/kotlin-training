package training.chapter3

class CountingSet<T> (
    val innerSet : MutableCollection<T> = HashSet<T>()
) : MutableCollection<T> by innerSet {  //MutableCollection 의 구현을 innerSet 에게 위임한다
    
    var objectsAdded = 0


    // 2개의 메소드는위임하지 않고 새로운 구현을 제공한다.
    override fun add(element: T) : Boolean {
        objectsAdded++
        return innerSet.add(element)
    }

    override fun addAll(c: Collection<T>): Boolean {
        objectsAdded += c.size
        return innerSet.addAll(c)
    }
}

class Test

fun main() {
    val cset = CountingSet<Int>()
    cset.addAll(listOf(1,2,3))
    println("list : ${cset.objectsAdded} objects were added, ${cset.size} remain")
}