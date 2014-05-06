(ns org.collagen.plugin.CollagenToolWindowFactory
  (:import [com.intellij.openapi.wm ToolWindowFactory ToolWindow]
    [com.intellij.openapi.project Project]
    [javax.swing JLabel JPanel JButton JTextField BoxLayout Box JTextArea]
    [java.awt FlowLayout])
  (:gen-class
    :name org.collagen.plugin.CollagenToolWindowFactory
    :implements [com.intellij.openapi.wm.ToolWindowFactory]))

(defn contentFactory []
  (com.intellij.ui.content.ContentFactory$SERVICE/getInstance))

(defn toolWindowContent []
  (let [rootPanel (JPanel.)
        rootLayout (BoxLayout. rootPanel BoxLayout/PAGE_AXIS)
        serverPanel (JPanel. (FlowLayout. FlowLayout/LEFT 5 5))
        clientPanel (JPanel. (FlowLayout. FlowLayout/LEFT 5 5))]
    (.add serverPanel (JButton. "Start server"))
    (.add clientPanel (JLabel. "Host:"))
    (.add clientPanel (JTextField. 20))
    (.add clientPanel (JButton. "Connect"))
    (.setLayout rootPanel rootLayout)
    (.add rootPanel serverPanel)
    (.add rootPanel clientPanel)
    (.add rootPanel (JToolBar.))
    rootPanel))

(defn -createToolWindowContent [this #^Project project #^ToolWindow toolWindow]
  (.addContent (.getContentManager toolWindow)
    (.createContent (contentFactory) (toolWindowContent) "" false)))
