(ns org.collagen.plugin.ToolWindowFactory
  (:gen-class
    :name org.collagen.plugin.ToolWindowFactory
    :implements [com.intellij.openapi.wm.ToolWindowFactory])
  (:import [com.intellij.openapi.wm ToolWindowFactory ToolWindow]
           [com.intellij.openapi.project Project]))

(defn createToolWindowContent
  [#^Project project #^ToolWindow toolWindow]
  ())
