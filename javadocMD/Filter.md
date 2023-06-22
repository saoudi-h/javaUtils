# Documentation

## `public interface Filtre<T>`

L'interface Filtre représente un filtre qui peut être appliqué à un objet de type T. Un filtre permet de déterminer si un objet satisfait une condition spécifique.

* **Parameters:** `<T>` — le type d'objet sur lequel le filtre est appliqué

## `boolean apply(T t)`

Vérifie si l'objet spécifié satisfait le critère du filtre.

* **Parameters:** `t` — l'objet à évaluer
* **Returns:** true si l'objet satisfait le critère du filtre, sinon false