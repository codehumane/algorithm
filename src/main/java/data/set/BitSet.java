package data.set;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class BitSet {

    private int capacity;
    private int bits;

    public BitSet(int capacity) {
        assert capacity >= 0;
        this.capacity = capacity;
        this.bits = 0;
    }

    public void set(int index) {
        assert index < capacity;
        bits |= 1 << index;
    }

    public void clear(int index) {
        assert index < capacity;
        bits &= ~(1 << index);
    }

    public void toggle(int index) {
        assert index < capacity;
        bits ^= (1 << index);
    }

    public void full() {
        bits = (1 << capacity) - 1;
    }

    public void empty() {
        bits = 0;
    }

    public boolean isFull() {
        return capacity == count();
    }

    public boolean isEmpty() {
        return bits == 0;
    }

    public int count() {
        return Integer.bitCount(bits);
    }

    public void union(BitSet source) {
        bits |= source.bits;
    }

    public void intersect(BitSet source) {
        bits &= source.bits;
    }

    public void difference(BitSet source) {
        bits &= ~source.bits;
    }

    public Set getSubsets() {
        Set<Integer> subsets = new HashSet<Integer>();
        for (int subset = bits; subset != 0; subset = ((subset - 1) & bits)) {
            subsets.add(subset);
        }
        return subsets;
    }

    @Override
    public String toString() {
        return toBinary(bits);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (!(object instanceof BitSet))
            return false;
        BitSet target = (BitSet) object;
        return capacity == target.capacity && bits == target.bits;
    }

    private String toBinary(int input) {
        String binaryString = Integer.toBinaryString(input);
        return String.format("%" + capacity + "s", binaryString).replace(" ", "0");
    }

    public int firstSetIndex() {
        int index = capacity - 1;
        while (index > 0) {
            int operand = 1 << index;
            if ((operand & bits) == operand) {
                break;
            }

            index--;
        }

        return index;
    }

    public int lastSetIndex() {
        int index = 0;
        int operated = bits;
        while (operated > 0) {
            if ((operated & 1) == 1) {
                break;
            }

            operated = operated >> 1;
            index++;
        }

        return index;
    }

    //    public int lastSetIndex() {
    //        int index = 0;
    //        int xorOperated = bits;
    //        while (xorOperated >= bits) {
    //            xorOperated ^= (1 << index);
    //            index++;
    //        }
    //        return index - 1;
    //    }
}
