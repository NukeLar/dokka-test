package plugins.multiplatform


/**
 * Precompiled [dokka-multiplatform.gradle.kts][plugins.multiplatform.Dokka_multiplatform_gradle] script plugin.
 *
 * @see plugins.multiplatform.Dokka_multiplatform_gradle
 */
public
class DokkaMultiplatformPlugin : org.gradle.api.Plugin<org.gradle.api.Project> {
    override fun apply(target: org.gradle.api.Project) {
        try {
            Class
                .forName("plugins.multiplatform.Dokka_multiplatform_gradle")
                .getDeclaredConstructor(org.gradle.api.Project::class.java, org.gradle.api.Project::class.java)
                .newInstance(target, target)
        } catch (e: java.lang.reflect.InvocationTargetException) {
            throw e.targetException
        }
    }
}
