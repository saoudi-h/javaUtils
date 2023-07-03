package com.saoudi.javaUtils;

/**
 * L'interface Filtre représente un filtre qui peut être appliqué à un objet de type T.
 * Un filtre permet de déterminer si un objet satisfait une condition spécifique.
 *
 * @param <T> le type d'objet sur lequel le .
 *           filtre est appliqué
 */
public interface Filtre<T> {

    /**
     * Vérifie si l'objet spécifié satisfait le critère du filtre.
     *
     * @param t l'objet à évaluer
     * @return true si l'objet satisfait le critère du filtre, sinon false
     */
    boolean apply(T t);
}