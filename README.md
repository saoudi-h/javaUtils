# Class List - Structure de données doublement chaînée

La classe `List` est une implémentation d'une structure de données doublement chaînée en Java. Elle offre des fonctionnalités de base telles que l'insertion, la suppression, l'accès aux éléments et bien d'autres.

Ce projet a été réalisé dans le cadre de l'apprentissage des concepts avancés de la programmation orientée objet en Java. La classe List offre une manière flexible et générique de manipuler une structure de données doublement chaînée.

## Fonctionnalités

- Insertion d'éléments au début de la liste (`push`)
- Insertion d'éléments à la fin de la liste (`append`)
- Insertion d'éléments à un index spécifié (`insert`)
- Accès à un élément à partir de son index (`get`)
- Modification d'un élément à un index spécifié (`set`)
- Suppression d'un élément à un index spécifié (`remove`)
- Recherche d'un élément satisfaisant un critère spécifié (`getFirst`)
- Vérification si la liste est vide (`isEmpty`)
- Effacement de tous les éléments de la liste (`clear`)

## Utilisation

Pour tester la classe `List`, vous pouvez télécharger le répertoire:

```bash
git clone https://github.com/saoudi-h/javaUtils.git 
```

## Tests
Ce projet utilise JUnit pour les tests unitaires. Les tests sont situés dans le répertoire src/test/java. Vous pouvez exécuter les tests à l'aide de la commande suivante :

```bash
mvn test
```

## Génération du fichier JAR exécutable

Ce projet est configuré avec le plugin Maven maven-jar-plugin pour générer un fichier JAR exécutable. Vous pouvez générer le JAR en exécutant la commande suivante :
```bash
mvn verify
```
Le fichier JAR exécutable sera généré dans le répertoire target, situé a la racine du projet.
```bash
cd target
java -jar javaUtils-1.0-SNAPSHOT.jar
```

## Contributeurs

Développé par Hakim Saoudi dans le cadre de sa formation de concepteur développeur d'application.

## Licence

Ce mini projet est sous licence [MIT](https://opensource.org/licenses/MIT).