### Reviewer #1
Questions
#### 1. Please summarize the main claims/contributions of the paper in your own words.
This paper proposed a framework for CT-based lung nodule diagnosis, where the two tasks FPR and MSE are combined into a 3D convlutional neural network.
#### 2. Please give your detailed comments on English, novelty, technical soundness, experimental results, etc., including strength and weakness, and also provide constructive suggestions. (visible to authors)
1. The overall framework is reasonable and results are good.

2. The background is not introduced in a satisfactory manner. For example, FPR and MSE are not defined or introduced in detail, but they definitely are not familiar to the PRCV community.

3. More ablative studies are highly encouraged to illustrate how the combined 3D conv structure handles MSE and FPR and why that can replace a two-stage task.
#### 3. Recommendation
Accept as Poster
#### 4. Confidence
Meduim: Knowledgable

### Reviewer #2
Questions
#### 1. Please summarize the main claims/contributions of the paper in your own words.
This manuscript proposes a new framework called Attribute Sensitive Multi-Branch 3D CNN (ASMB3DCNN) that performs the fine grain lung nodule classification. The authors split the label "real nodule" defined in FPR into two new finer grain labels, namely "low risk" and "high risk". In addition, the authors present a novel Attribute Sensitive Multi-Branch 3D CNN. They claim that ASMB3DCNN can efficiently address the two tasks (LIDC-IDRI and LUNA16 datasets) above in a joint way and achieve the promising performances.
#### 2. Please give your detailed comments on English, novelty, technical soundness, experimental results, etc., including strength and weakness, and also provide constructive suggestions. (visible to authors)
Weakness:
1, What is the technology contributions in this paper? So the authors should restate their contributions.
2, The related work for 3D CNN is not extensive. Please add more related works. Such as:
[Du Tran et al, Learning Spatiotemporal Features with 3D Convolutional Networks, ICCV'2015]
[Joso Carreira et al, Quo Vadis, Action Recognition? A New Model and the Kinetics Dataset, CVPR'2017]
[Saining Xie et al, Rethinking Spatiotemporal Feature Learning For Video Understanding, arXiv'2017]
3, In experiments section, please add more complexity analysis for the proposed multi-branch 3D CNN. Usually, larger gpu memory is needed for 3D CNN than 2D CNN.
4, The authors proposed model can not get the promising performance in comparison with the state-of-the-arts methods in Table 4, how to claim the effectiveness of your proposed model. In addition, the results in table 3 is on LIDC-IDRI or LUNA2016 dataset? The results in Table 3 is the same on these two datasets?
5, The authors should polish the presentations. Example writing issues include: "3D CNN" not "3-D CNN". "3d" and "ct" need to be changed to upper case in bibliography. "LUNA16" in abstract and "LUNA2016" in section 3.1 should keep the same.
#### 3. Recommendation
Reject
#### 4. Confidence
Meduim: Knowledgable

### Reviewer #3
Questions
#### 1. Please summarize the main claims/contributions of the paper in your own words.
In this paper, the authors merge the False Positive Reduction (FPR) task and Malignancy Suspiciousness Estimation (MSE) task in the lung nodule diagnosis field into a unified fine grain lung nodule classification problem by splitting the label “real nodule” defined in FPR into two finer labels defined in MSE. They also select the most usable attributes via measuring their sensitivity to get good semantic features for classification. A method of normalization of inputs is implemented for higher accuracy of classification and less calculation.
#### 2. Please give your detailed comments on English, novelty, technical soundness, experimental results, etc., including strength and weakness, and also provide constructive suggestions. (visible to authors)
Overall, the idea is novel and the result is good. But there are several important details missing, making this paper difficult to understand.

Major problems:
1、The authors use attributes information to improve the model performance. But many details are missing, e.g., what attributes are used, how to train the network to extract these attribute information, how the attribute features are applied to the final prediction, and so on. This makes many parts of this paper hard to understand, such as the term “levels of attributes”, to which the author refer when describing how to measure the sensitivity of an attribute in section 2.1. What does this term mean? Please carefully clarify these missing details.
2、It’s not clear the proposed network is trained with patches or images. Please clarify.
3、Based on my understanding, the fine grain classification architecture is not used in Section 3.3 and 3.4. Only a single prediction layer is used to predict MSE in section 3.3 and FPR in section 3.4, respectively. Is it true? The authors should clearly state this information.
4、The names of the last two rows in Table 5, i.e., ‘MSE’ and ‘FPR’, seems to be reversed. Since the labels defined in MSE are high-risk and low-risk and the labels defined in FPR and ‘real nodule’ and ‘false nodule’. 

Minor issues：
1、In section 3.4, the author state that the accuracy gain of ASMB3DCNN(ALL) over the FPR+Attributes version is 0.5%. This is not true in Table 4. Please check.
2、On line 5 of the second paragraph of Section 2.1, there is a space missing in “internalStructure”.
3、On line 5 of page 10, “99.0%” should be “90.0” according to Table 5.
#### 3. Recommendation
Accept as Poster
#### 4. Confidence
High: Expert

### Reviewer #5
Questions
#### 1. Please summarize the main claims/contributions of the paper in your own words.
In this paper, the authors merge two separated issues, False Positive Reduction (FPR) and Malignancy Suspiciousness Estimation (MSE), into one classification task in lung nodule diagnosis. Then, a novel Attribute Sensitive Multi-Branch 3-D CNN (ASMB3DCNN) is proposed to solve it. The experiments show that proposed ASMB3DCNN achieve good performances on both FPR and MSE.
#### 2. Please give your detailed comments on English, novelty, technical soundness, experimental results, etc., including strength and weakness, and also provide constructive suggestions. (visible to authors)
The article finds that the knowledge learned in attribution prediction network is hlepful to FPR and MSE task.Moreover,these two task have strong correlation and can be merged into one classification task. The autthors also propose a network called ASMB3DCNN to improve the performance both on FPR and MSE.The experimental results and analysis fully demonstrate the findings.
#### 3. Recommendation
Accept as Poster
#### 4. Confidence
Low: Educated Guess





背景没有以令人满意的方式介绍。例如，FPR和MSE没有详细定义或介绍，但它们对PRCV社区肯定不熟悉。

非常鼓励更多的烧蚀研究来说明组合3D转换结构如何处理MSE和FPR以及为什么它可以取代两阶段任务。

缺点：1，本文的技术贡献是什么？所以作者应该重申他们的贡献。2，3D CNN的相关工作并不广泛。请添加更多相关作品。例如：[Du Tran et al，Learning Spatiotemporal Features with 3D Convolutional Networks，ICCV'2015] [Joso Carreira et al，Quo Vadis，Action Recognition？一个新的模型和动力学数据集，CVPR'2017] [Saining Xie等，重新思考时空特征学习视频理解，arXiv'2017] 3，在实验部分，请为所提出的多分支3D CNN添加更多的复杂性分析。通常，3D CNN需要比2D CNN更大的gpu存储器。4，作者提出的模型与表4中的现有技术方法相比，无法获得有希望的表现，如何宣称您提出的模型的有效性。此外，表3中的结果是在LIDC-IDRI或LUNA2016数据集上？表3中的结果在这两个数据集上是相同的？5，作者应该对演示文稿进行修改。示例写作问题包括：“3D CNN”而不是“3-D CNN”。在参考书目中，“3d”和“ct”需要改为大写。摘要中的“LUNA16”和3.1节中的“LUNA2016”应保持不变。


总的来说，这个想法很新颖，结果很好。但是缺少一些重要的细节，使得这篇论文难以理解。

主要问题：1，作者使用属性信息来提高模型性能。但是缺少许多细节，例如，使用什么属性，如何训练网络以提取这些属性信息，如何将属性特征应用于最终预测，等等。这使得本文的许多部分难以理解，例如术语“属性级别”，作者在描述如何在2.1节中测量属性的灵敏度时参考。这个术语是什么意思？请仔细澄清这些遗漏的细节。2，目前尚不清楚拟议的网络是否经过补丁或图像训练。请澄清。3，根据我的理解，第3.3和3.4节没有使用细粒度分类架构。在3.4节中仅使用单个预测层来预测MSE，在3.4节中使用FPR，分别。这是真的吗？作者应明确说明这些信息。4，表5中最后两行的名称，即“MSE”和“FPR”，似乎是相反的。由于MSE中定义的标签具有高风险和低风险，并且标签在FPR和“真实结节”和“假结节”中定义。

次要问题：1，在3.4节中，作者声明ASMB3DCNN（ALL）相对于FPR +属性版本的准确度增益为0.5％。表4中的情况并非如此。请检查。2，在第2.1节第2段的第5行，“internalStructure”中缺少一个空格。3，在第10页的第5行，根据表5，“99.0％”应为“90.0”。

本文发现归因预测网络中学到的知识对于FPR和MSE任务是有益的。而且，这两个任务具有很强的相关性，可以合并为一个分类任务。autthors还提出了一个名为ASMB3DCNN的网络，以提高FPR和MSE的性能。实验结果和分析充分证明了这些发现。