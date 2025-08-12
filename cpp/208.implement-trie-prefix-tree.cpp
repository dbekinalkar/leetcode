/*
 * @lc app=leetcode id=208 lang=cpp
 *
 * [208] Implement Trie (Prefix Tree)
 */

// @lc code=start
struct Vertex {
    int next[26] = {};
    bool output = false;
};

class Trie {
public:
    Trie() : trie_(1) {
        
    }
    
    void insert(string word) {
        int v = 0;

        for(char ch : word) {
            int c = ch - 'a';
            if(!trie_[v].next[c]) {
                trie_[v].next[c] = trie_.size();
                trie_.push_back({});
            }

            v = trie_[v].next[c];
        }

        trie_[v].output = true;
    }
    
    bool search(string word) {
        int v = 0;

        for(char ch : word) {
            int c = ch - 'a';
            if(!trie_[v].next[c]) {
                return false;
            }

            v = trie_[v].next[c];
        }

        return trie_[v].output;
    }
    
    bool startsWith(string prefix) {
        int v = 0;

        for(char ch : prefix) {
            int c = ch - 'a';
            if(!trie_[v].next[c]) {
                return false;
            }

            v = trie_[v].next[c];
        }

        return true;
    }

    vector<Vertex> trie_;
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */
// @lc code=end

