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

description = "Tagging Samples Module"

moduleManifest {
  moduleName.set("taggingSamples")
  runtimeProfile.set(rt)
}

dependencies {
  nre("Tridium:nre")
  api("Tridium:baja")
  api("Tridium:tagdictionary-rt")

  moduleTestImplementation("Tridium:test-wb")
}

