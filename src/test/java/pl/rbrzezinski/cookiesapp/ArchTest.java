package pl.rbrzezinski.cookiesapp;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("pl.rbrzezinski.cookiesapp");

        noClasses()
            .that()
            .resideInAnyPackage("pl.rbrzezinski.cookiesapp.service..")
            .or()
            .resideInAnyPackage("pl.rbrzezinski.cookiesapp.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..pl.rbrzezinski.cookiesapp.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
