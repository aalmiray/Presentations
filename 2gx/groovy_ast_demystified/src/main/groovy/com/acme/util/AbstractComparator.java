package com.acme.util;

import java.util.Comparator;

public abstract class AbstractComparator<T> implements Comparator<T> {
    public boolean equals(Object obj) {
        return this == obj;
    }
}