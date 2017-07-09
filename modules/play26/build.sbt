/**
 * File     : build.sbt
 * License  :
 *   The MIT License (MIT)
 *
 *   Original   - Copyright (c) 2014 Jöerg Viola, Marco Sinigaglia
 *   Derivative - Copyright (c) 2016 Citadel Technology Solutions Pte Ltd
 *
 *   Permission is hereby granted, free of charge, to any person obtaining a copy
 *   of this software and associated documentation files (the "Software"), to deal
 *   in the Software without restriction, including without limitation the rights
 *   to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *   copies of the Software, and to permit persons to whom the Software is
 *   furnished to do so, subject to the following conditions:
 *
 *   The above copyright notice and this permission notice shall be included in all
 *   copies or substantial portions of the Software.
 *
 *   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *   FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *   AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *   LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *   SOFTWARE.
 */
name := """play2-scala-pdf"""

organization := "com.appliedscala"

version := "1.6.2.P26"

scalaVersion := "2.12.2"

crossScalaVersions := Seq("2.12.2")

libraryDependencies ++= Seq(
  guice,
  // Apache Commons IO
  //   - https://commons.apache.org/proper/commons-io/
  "commons-io" % "commons-io" % "2.5",

  // HTML parsing + PDF generation
  //   - http://jtidy.sourceforge.net/
  //   - https://code.google.com/archive/p/flying-saucer/
  //   - https://about.validator.nu/htmlparser/
  "net.sf.jtidy" % "jtidy" % "r938",
  "org.xhtmlrenderer" % "flying-saucer-pdf" % "9.1.1" excludeAll(
    ExclusionRule(organization = "bouncycastle")
  ),
  "nu.validator.htmlparser" % "htmlparser" % "1.4",

  // Re-import Bouncy Castle dependency from new coordinates
  "org.bouncycastle" % "bcmail-jdk14" % "1.38",
  "org.bouncycastle" % "bcprov-jdk14" % "1.38",
  "org.bouncycastle" % "bctsp-jdk14" % "1.38",

  // ScalaTest + Play plugin
  //   - http://www.scalatest.org/plus/play
  "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.0" % Test
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

lazy val play26 = (project in file(".")).enablePlugins(PlayScala)

licenses := Seq("Apache-2.0" -> url("http://opensource.org/licenses/Apache-2.0"))

lazy val publishSettingsBintray = Seq(
  publishMavenStyle := true,
//   repository in bintray := "maven",
  bintrayOrganization in bintray := Some("applied-scala")
)