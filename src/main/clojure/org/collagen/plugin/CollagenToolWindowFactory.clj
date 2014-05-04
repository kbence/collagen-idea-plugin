(ns org.collagen.plugin.CollagenToolWindowFactory)

(import [com.intellij.openapi.wm ToolWindowFactory ToolWindow]
         [com.intellij.openapi.project Project]
         [javax.swing JPanel])

(gen-class
  :name org.collagen.plugin.CollagenToolWindowFactory
  :implements [com.intellij.openapi.wm.ToolWindowFactory])

(defn contentFactory []
  (.getInstance com.intellij.ui.content.ContentFactory$SERVICE))

(defn -createToolWindowContent [#^Project project #^ToolWindow toolWindow]
  (.addContent (.getContentManager toolWindow)
    (.createContent (contentFactory) (JPanel.) "" false)))
