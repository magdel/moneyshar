package ru.moneyshar.site.generator;

import javax.annotation.Nonnull;

@FunctionalInterface
public interface IdGenerator {

    @Nonnull
    Long generate();

}