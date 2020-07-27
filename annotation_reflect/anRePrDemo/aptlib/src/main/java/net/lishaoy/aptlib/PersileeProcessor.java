package net.lishaoy.aptlib;


import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

@SupportedAnnotationTypes("net.lishaoy.anreprdemo.Persilee")
public class PersileeProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        Messager messager = processingEnv.getMessager();
        messager.printMessage(Diagnostic.Kind.NOTE, "APT working ...");
        for (TypeElement typeElement: set) {
            messager.printMessage(Diagnostic.Kind.NOTE,"===>" + typeElement.getQualifiedName());
            Set<? extends Element> elements = roundEnvironment.getElementsAnnotatedWith(typeElement);
            for (Element element: elements) {
                messager.printMessage(Diagnostic.Kind.NOTE,"===>" + element.getSimpleName());
            }
        }

        return true;
    }
}