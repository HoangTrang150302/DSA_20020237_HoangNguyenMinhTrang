package Buoi12;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Cell {
    public int r, c;
    public Cell(int i, int j) {
        r = i;
        c = j;
        countAdj = 0;
    }
    public int countAdj = 0;
}

