(ns bank-account)

(defn open-account []
  (atom 0))

(defn close-account [acct]
  (reset! acct nil))

(defn get-balance [acct]
  @acct)

(defn update-balance [acct amt]
  (reset! acct (+ @acct amt)))
