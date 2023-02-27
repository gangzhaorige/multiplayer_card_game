using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Card : ScriptableObject {

    private int rank;

    public Card(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return this.rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
    
}
