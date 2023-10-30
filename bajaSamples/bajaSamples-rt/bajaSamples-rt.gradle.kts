/* Module Build File */

import com.tridium.gradle.plugins.module.util.ModulePart.RuntimeProfile.rt

plugins {
  id("com.tridium.niagara-module")
  id("com.tridium.niagara-signing")
  id("com.tridium.bajadoc")
  id("com.tridium.niagara-jacoco")
  id("com.tridium.niagara-annotation-processors")
  id("com.tridium.convention.niagara-home-repositories")
  id("com.tridium.bajadoc-module")
}

description = "Baja Samples Module"

moduleManifest {
  moduleName.set("bajaSamples")
  runtimeProfile.set(rt)
}

dependencies {
  nre("Tridium:nre")
  api("Tridium:baja")

  moduleTestImplementation("Tridium:test-wb")
}

tasks.named<Jar>("jar") {
  from("src") {
    include("images/")
    include("lexicons/")
  }
}
