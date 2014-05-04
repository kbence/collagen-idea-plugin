(ns org.collagen.plugin.CollagenToolWindowFactory
  (:import [com.intellij.openapi.wm ToolWindowFactory ToolWindow]
    [com.intellij.openapi.project Project]
    [javax.swing JLabel])
  (:gen-class
    :name org.collagen.plugin.CollagenToolWindowFactory
    :implements [com.intellij.openapi.wm.ToolWindowFactory]))

(defn contentFactory []
  (com.intellij.ui.content.ContentFactory$SERVICE/getInstance))

(defn -createToolWindowContent [this #^Project project #^ToolWindow toolWindow]
  (.addContent (.getContentManager toolWindow)
    (.createContent (contentFactory) (JLabel. "Collagen plugin") "" false)))
